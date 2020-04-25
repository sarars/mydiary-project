package com.sample.project;

public final class ConfigurationChangeListener {

/*implements Runnable {
	
	private String configFileName;
	private final String fullFilePath;
	
	public ConfigurationChangeListener(final String fullFilePath) {
		this.fullFilePath = fullFilePath;
	}

	@Override
	public void run() {
		try {
			register(this.fullFilePath);
		}catch(IOException e ) {
			//e.printStackTrace(); // TODO: Use logger call instead
			System.out.println(e.getMessage());
		}
		
	}

	private void register(final String fullFilePath) throws IOException {
		final int lastIndex = fullFilePath.lastIndexOf('/');
		final String dirPath = fullFilePath.substring(0,lastIndex+1);
		final String fileName = fullFilePath.substring(lastIndex+1,fullFilePath.length());
		this.configFileName = fileName;
				
		configurationChanged(fullFilePath);
		startWatcher(dirPath,fileName);
	}

	private void startWatcher( final String dirPath, final String fileName) throws IOException {
		final WatchService watchService = FileSystems.getDefault().newWatchService();
		final Path path = Paths.get(dirPath);
		path.register(watchService, ENTRY_MODIFY);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					watchService.close();
				}catch(IOException e){
					//e.printStackTrace(); // TODO: Use logger call instead
					System.out.println(e.getMessage());
				}
			}
		});
		
		WatchKey key = null;
		while(true) {
			try {
				key = watchService.take();
				for( final WatchEvent<?> event : key.pollEvents() ) {
					if(event.context().toString().equals(configFileName)) {
						configurationChanged(dirPath+fileName);
					}
				}
				final boolean reset = key.reset();
				if ( !reset ) {
					System.out.println("Could not reset the watch key");
					break;
				}
			} catch (InterruptedException e) {
				//e.printStackTrace(); // TODO: Use logger call instead
				System.out.println("Interrupted Exception " + e.getMessage());
			}
		}
	}

	private void configurationChanged(final String fullFilePath) {
		System.out.println("Refreshing the configuration");
		ApplicationConfiguration.getInstance().initialize(fullFilePath);
	}

*/}

package thread1;

public class ThreadPoolTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=2){
			System.out.println("用法：java ThreadPool numTasks poolSize");
			System.out.println("numTasks - integer: 任务的数目");
			System.out.println("numThreads - integer :线程池中的线程数目");
			return;
		}
		int numTasks=Integer.valueOf(args[0]);
		int poolSize=Integer.valueOf(args[1]);
/*		int numTasks=5;
		int poolSize=3;*/
		ThreadPool threadPool=new ThreadPool(poolSize);
		for (int i = 0; i < numTasks; i++) {
			threadPool.execute(createTask(i));
		}
		threadPool.join();
	}

	private static Runnable createTask(final int taskID) {
		// TODO Auto-generated method stub
		return new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Task"+taskID+":start");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					System.out.println("Task"+taskID+":end");
				}
			}
		};
	}

}

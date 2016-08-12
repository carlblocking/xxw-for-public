package thread1;

import java.util.LinkedList;

public class ThreadPool extends ThreadGroup {
	private boolean isClosed=false;//线程池是否关闭
	private LinkedList<Runnable> workQueue;//表示工作队列
	private static int threadPoolID;//表示线程池ID
	private int threadID;//表示线程ID
	public ThreadPool(int poolSize) {
		super("ThreadPool"+(threadPoolID++));
		setDaemon(true);
		workQueue=new LinkedList<Runnable>();
		for (int i = 0; i < poolSize; i++) {
			new WorkThread().start();
		}
		// TODO Auto-generated constructor stub
	}

	/**向工作队列中加入一个新任务，由工作线程去执行该任务*/
	public synchronized void execute(Runnable task){
		if(isClosed){
			throw new IllegalStateException();
		}
		if(task!=null){
			workQueue.add(task);
			notify();
		}
	}
	protected synchronized Runnable getTask()throws InterruptedException{
		while (workQueue.size()==0) {
			if(isClosed)return null;
			wait();
		}
		return workQueue.removeFirst();
	}
	public synchronized void close(){
		if(!isClosed){
			isClosed=true;
			workQueue.clear();
			interrupt();
		}
	}
	public void join(){
		synchronized (this) {
			isClosed=true;
			notifyAll();
		}
		Thread[] threads=new Thread[activeCount()];
		int count=enumerate(threads);
		for (int i = 0; i < count; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	private class WorkThread extends Thread{
		public WorkThread(){
			super(ThreadPool.this,"WorkThread-"+(threadID++));
		}

		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (!isInterrupted()) {
				Runnable task=null;
				try {
					task=getTask();
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				if(task==null)return;
				try {
					task.run();
				} catch (Throwable e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

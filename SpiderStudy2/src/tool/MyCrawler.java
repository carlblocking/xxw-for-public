package tool;

import java.util.Set;

public class MyCrawler {
	private void initCrawlerWithSeeds(String[] seeds){
		for (int i = 0; i < seeds.length; i++) {
			LinkQueue.addUnvisitedUrl(seeds[i]);
		}
	}
	private boolean count(String url){
		int i=url.length();
		int count=0;
		for (int j = 0; j < i; j++) {
			if (url.charAt(count)=='/') {
				count++;
			}
		}
		if (count==4) {
			return true;
		}
		else {
			return false;
		}
	}
	public void crawling(String[] seeds){
		LinkFilter filter=new LinkFilter() {
			
			public boolean accept(String url) {
				// TODO Auto-generated method stub
				if(url.startsWith("http://www.zhihu.com/people/"))
				//if(new DealUrl().dealUrl(url))
					return true;
				else
					return false;
			}
		};
		initCrawlerWithSeeds(seeds);
		while (!LinkQueue.unVisitedUrlIsEmpty()
				&&LinkQueue.getVisitedUrlNum()<=100) {
			String visitedUrl=(String)LinkQueue.unVisitedUrlDeQueue();
			if(visitedUrl==null)
				continue;
			DownLoadFile downLoadFile=new DownLoadFile();
			downLoadFile.downloadFile(visitedUrl);
			LinkQueue.addVisitedUrl(visitedUrl);
			Set<String> links=HtmlParserTool.extractLinks(visitedUrl, filter);
			for (String link:links) {
				LinkQueue.addUnvisitedUrl(link);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCrawler crawler=new MyCrawler();
		crawler.crawling(new String[]{"http://www.zhihu.com/people/xue-xiao-wei-33"});
	}

}

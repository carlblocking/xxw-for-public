package tool;

import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;

public class Demo2 {
	public static void main(String[] args0){
		String url="http://www.zhihu.com";
		try {
			Parser parser=new Parser(url);
			NodeVisitor visitor=new NodeVisitor() {
				public void visitTag(Tag tag){
					if(tag instanceof LinkTag){
						LinkTag link=(LinkTag)tag;
						System.out.println(((LinkTag) tag).getLink());
					}
				}
			};
			parser.visitAllNodesWith(visitor);
		} catch (ParserException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

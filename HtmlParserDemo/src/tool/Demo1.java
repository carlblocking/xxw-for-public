package tool;



import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;

public class Demo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Parser parser=new Parser();
			parser.setURL("http://www.baidu.com");
			parser.setEncoding(parser.getEncoding());
			NodeVisitor visitor=new NodeVisitor() {
				public void visitTag(Tag tag){
					System.out.println(tag.getTagName());
				}
			};
			parser.visitAllNodesWith(visitor);
		} catch (ParserException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

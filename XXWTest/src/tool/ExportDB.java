package tool;

import java.util.EnumSet;

import oracle.net.aso.l;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class ExportDB {
	public static void main(String[]args){  
/*        //默认读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration().configure();  
        ////生成并输出sql到文件（当前目录）和数据库  
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, true);  */
		Configuration configuration=new Configuration().configure();
		SchemaExport export=new SchemaExport(configuration);
		export.create(true, true);
    }  
}

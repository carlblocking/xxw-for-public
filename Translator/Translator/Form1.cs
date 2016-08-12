using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Net;
using System.Security.Cryptography;
using System.IO;
using Newtonsoft.Json;
namespace Translator
{
    public partial class Form1 : Form
    {
        string url = "";
        public Form1()
        {
            InitializeComponent();
        }

        public String md5(String s)
        {
            System.Security.Cryptography.MD5 md5 = new System.Security.Cryptography.MD5CryptoServiceProvider();
            byte[] bytes = System.Text.Encoding.UTF8.GetBytes(s);
            bytes = md5.ComputeHash(bytes);
            md5.Clear();
            string ret = "";
            for (int i = 0; i < bytes.Length;i++ )
            {
                ret += Convert.ToString(bytes[i],16).PadLeft(2,'0');
            }
            return ret.PadLeft(32,'0');
        }
        private void button2_Click(object sender, EventArgs e)
        {
            AboutBox1 formabout = new AboutBox1();
            formabout.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Random random=new Random();
            int salt=random.Next(0,10001);
            WebClient client = new WebClient();
            string beifanyi = textBox1.Text.ToString();//要翻译的句子
            string sign=md5("123456789"+beifanyi+salt.ToString()+"123456789");//这里使用自己申请的百度秘钥
            string sign1 = sign.ToLower();
            if (!string.IsNullOrEmpty(beifanyi))
            {
                string url = String.Format("http://api.fanyi.baidu.com/api/trans/vip/translate?q={0}&from=en&to=zh&appid=20160612000023173&salt={1}&sign={2}", beifanyi, salt, sign1);
                //string url = string.Format("http://openapi.baidu.com/public/2.0/bmt/translate?client_id={0}&q={1}&from={2}&to={3}", "20160612000023173", beifanyi, "en", "ch");
                var bufer = client.DownloadData(url);
                string result = Encoding.UTF8.GetString(bufer);
                StringReader sr = new StringReader(result);
                JsonTextReader jsonReader = new JsonTextReader(sr);
                JsonSerializer serializer = new JsonSerializer();
                var r = serializer.Deserialize<TranClass>(jsonReader);
                textBox2.Text = r.Trans_result[0].dst;
                //textBox2.Text = result.ToString();
                //textBox2.Text = sign1;
            }
        }
    }
}

package test.baway.com.io2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String news_title;
    private Button btn, btn1;
    private String s = "{\"status\":1,\"info\":\"\\u83b7\\u53d6\\u5185\\u5bb9\\u6210\\u529f\",\"data\":[{\"news_id\":\"13811\",\"news_title\":\"\\u6df1\\u6e2f\\u6fb3\\u53f0\\u5343\\u91cc\\u8fde\\u7ebf\\uff0c\\u5609\\u5e74\\u534e\\u4f1a\\u4eca\\u590f\\u5165\\u5ddd\",\"news_summary\":\"6\\u670817\\u201420\\u65e5\\uff0c\\u201c2016\\u6210\\u90fd\\u6df1\\u6e2f\\u6fb3\\u53f0\\u5609\\u5e74\\u534e\\u4f1a\\u201d(\\u7b80\\u79f0\\u5609\\u5e74\\u534e\\u4f1a)\\u5c06\\u5728\\u6210\\u90fd\\u4e16\\u7eaa\\u57ce\\u56fd\\u9645\\u4f1a\\u5c55\\u4e2d\\u5fc3\\u4e3e\\u529e\\u3002\\u5176\\u4e3b\\u529e\\u65b9\\u52b1\\u5c55\\u534e\\u535a\\u501f\\u529b\\u65d7\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/21\\/887844_230x162_0.jpg\"},{\"news_id\":\"13810\",\"news_title\":\"\\u7b2c14\\u5c4a\\u6e29\\u5dde\\u56fd\\u9645\\u6c7d\\u8f66\\u5c554\\u6708\\u4e3e\\u884c \\u8bbe9\\u5927\\u4e3b\\u9898\\u5c55\\u9986\",\"news_summary\":\"\\u6765\\u81ea\\u524d\\u4e0d\\u4e45\\u4e3e\\u884c\\u7684\\u6e29\\u5dde\\u56fd\\u9645\\u6c7d\\u8f66\\u5c55\\u89c8\\u4f1a\\u7b2c\\u4e00\\u6b21\\u65b0\\u95fb\\u53d1\\u5e03\\u4f1a\\u7684\\u6d88\\u606f\\uff0c 2016\\u7b2c14\\u5c4a\\u6e29\\u5dde\\u56fd\\u9645\\u6c7d\\u8f66\\u5c55\\u89c8\\u4f1a\\u5b9a\\u4e8e4\\u67087-10\\u65e5\\u5728\\u6e29\\u5dde\\u56fd\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/21\\/580828_230x162_0.jpg\"},{\"news_id\":\"13808\",\"news_title\":\"\\u7b2c\\u5341\\u4e8c\\u5c4a\\u4e2d\\u56fd(\\u5357\\u5b89)\\u56fd\\u9645\\u6c34\\u6696\\u6cf5\\u9600\\u4ea4\\u6613\\u4f1a \\u56db\\u5927\\u4eae\\u70b9\",\"news_summary\":\"\\u7b2c\\u5341\\u4e8c\\u5c4a\\u4e2d\\u56fd(\\u5357\\u5b89)\\u56fd\\u9645\\u6c34\\u6696\\u6cf5\\u9600\\u4ea4\\u6613\\u4f1a\\u5c06\\u4e8e2\\u670810\\u65e5\\u81f312\\u65e5(\\u5373\\u519c\\u5386\\u6b63\\u6708\\u521d\\u4e09\\u81f3\\u521d\\u4e94)\\u5728\\u6210\\u529f\\u56fd\\u9645\\u4f1a\\u5c55\\u4e2d\\u5fc3\\u62c9\\u5f00\\u5e37\\u5e55\\u3002\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/21\\/745921_230x162_0.jpg\"},{\"news_id\":\"13805\",\"news_title\":\"2016\\u4e0a\\u6d77\\u706f\\u5149\\u97f3\\u54cd\\u5c55 \\u5546\\u673a\\u65e0\\u9650\\uff0c\\u4e00\\u89e6\\u5373\\u53d1\",\"news_summary\":\"2016\\u4e0a\\u6d77\\u56fd\\u9645\\u4e13\\u4e1a\\u706f\\u5149\\u97f3\\u54cd\\u5c55\\u5373\\u65e5\\u8d77\\u5168\\u9762\\u542f\\u52a8\\uff0c\\u6d77\\u5185\\u5916\\u9ad8\\u7aef\\u6f14\\u827a\\u8bbe\\u5907\\u5546\\u8d38\\u5e73\\u53f0\\uff0c\\u5546\\u673a\\u65e0\\u9650\\uff0c\\u4e00\\u89e6\\u5373\\u53d1\\u30026\\u5927\\u6d32\\uff0c80\\u4e2a\\u56fd\\u5bb6\\uff0c25,\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/21\\/158040_230x162_0.jpg\"},{\"news_id\":\"13804\",\"news_title\":\"\\u7b2c\\u56db\\u5c4a\\u5357\\u4eac\\u56fd\\u9645\\u4f5b\\u4e8b\\u5c555\\u6708\\u4e3e\\u884c\",\"news_summary\":\"2016\\u5e74\\uff0c\\u201c\\u7b2c\\u56db\\u5c4a\\u5357\\u4eac\\u56fd\\u9645\\u4f5b\\u4e8b\\u6587\\u5316\\u7528\\u54c1\\u5c55\\u89c8\\u4f1a\\u201d\\u5c06\\u4e8e5\\u670826-29\\u65e5\\u5728\\u5357\\u4eac\\u56fd\\u9645\\u5c55\\u89c8\\u4e2d\\u5fc3\\u4e3e\\u529e\\u3002\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/21\\/865222_230x162_0.jpg\"},{\"news_id\":\"13802\",\"news_title\":\"\\u4e0a\\u6d77\\u56fd\\u9645\\u725b\\u4ed4\\u670d\\u88c5\\u535a\\u89c8\\u4f1a \\u62d3\\u5c55\\u56fd\\u9645\\u8d38\\u6613\\u5927\\u5e02\\u573a\",\"news_summary\":\"2016\\u5e74\\u7b2c\\u4e09\\u5c4a\\u4e0a\\u6d77\\u56fd\\u9645\\u725b\\u4ed4\\u670d\\u88c5\\u535a\\u89c8\\u4f1a\\u5c06\\u4e8e4\\u670819-21\\u65e5\\u518d\\u6b21\\u7480\\u74a8\\u518d\\u73b0\\u4e0a\\u6d77\\u4e16\\u535a\\u5c55\\u89c8\\u9986\\uff0c\\u5171\\u540c\\u63a2\\u8ba8\\u725b\\u4ed4\\u6d41\\u884c\\u8d8b\\u52bf\\uff0c\\u8be0\\u91ca\\u725b\\u4ed4\\u6587\\u5316\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/20\\/370858_230x162_0.jpg\"},{\"news_id\":\"13800\",\"news_title\":\"\\u7b2c\\u4e09\\u5c4a\\u5170\\u5dde\\u5e74\\u8d27\\u4f1a\\u5728\\u7518\\u8083\\u56fd\\u9645\\u4f1a\\u5c55\\u4e2d\\u5fc3\\u672c\\u670819\\u65e5\\u5f00\\u5e55\",\"news_summary\":\"\\u7531\\u4e2d\\u56fd\\u5546\\u4e1a\\u8054\\u5408\\u4f1a\\u3001\\u7518\\u8083\\u7701\\u5546\\u4e1a\\u8054\\u5408\\u4f1a\\u3001\\u5170\\u5dde\\u5e02\\u5546\\u52a1\\u5c40\\u4e3b\\u529e\\uff0c\\u7518\\u8083\\u7701\\u9152\\u7c7b\\u5546\\u54c1\\u7ba1\\u7406\\u5c40\\u3001\\u5170\\u5dde\\u5e02\\u57ce\\u5173\\u533a\\u5546\\u52a1\\u5c40\\u3001\\u7b2c\\u5341\\u56db\\u5c4a\\u897f\\u5b89\\u5e74\\u8d27\\u4f1a\\u7ec4\\u59d4\\u4f1a\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/20\\/868385_230x162_0.jpg\"},{\"news_id\":\"13799\",\"news_title\":\"\\u9996\\u5c4a\\u79fb\\u52a8\\u62cd\\u5356\\u827a\\u672f\\u535a\\u89c8\\u4f1a\\u542f\\u52a8\",\"news_summary\":\"\\u9996\\u5c4a\\u79fb\\u52a8\\u62cd\\u5356\\u535a\\u89c8\\u4f1a\\u5df2\\u4e8e2016\\u5e741\\u6708\\u5168\\u9762\\u542f\\u52a8\\uff0c\\u7531\\u5927\\u5496\\u62cd\\u5356\\u4e3b\\u529e\\uff0c\\u8054\\u5408\\u5168\\u56fd\\u827a\\u672f\\u673a\\u6784\\u5171\\u540c\\u6253\\u9020\\u62cd\\u5356\\u827a\\u672f\\u535a\\u89c8\\u4f1a\\u4e3b\\u4f1a\\u573a\\uff0c\\u8fd1\\u767e\\u573a\\u62cd\\u5356\\u4e13\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/20\\/768695_230x162_0.jpg\"},{\"news_id\":\"13798\",\"news_title\":\"\\u6b66\\u6c49\\u91d1\\u878d\\u7406\\u8d22\\u6295\\u8d44\\u535a\\u89c8\\u4f1a\\u5c06\\u57285\\u6708\\u4e3e\\u529e\",\"news_summary\":\"\\u7531\\u6b66\\u6c49\\u5e02\\u8d38\\u4fc3\\u4f1a\\u3001\\u4e0a\\u6d77\\u300a\\u7406\\u8d22\\u5468\\u520a\\u300b\\u793e\\u3001\\u6e56\\u5317\\u597d\\u535a\\u5854\\u82cf\\u65af\\u5c55\\u89c8\\u6709\\u9650\\u516c\\u53f8\\u7b49\\u5355\\u4f4d\\u8054\\u5408\\u53d1\\u8d77\\u7684\\u201c2016\\u6b66\\u6c49\\u91d1\\u878d\\u7406\\u8d22\\u6295\\u8d44\\u535a\\u89c8\\u4f1a\\u201d\\uff0c\\u5c06\\u5728\\u6b66\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/20\\/512947_230x162_0.jpg\"},{\"news_id\":\"13796\",\"news_title\":\"\\u7b2c\\u4e09\\u5c4a\\u4e2d\\u56fd\\u5fae\\u5546\\u535a\\u89c8\\u4f1a 3\\u6708\\u5e95\\u6d4e\\u5357\\u4e3e\\u529e\",\"news_summary\":\"2015\\u5e74\\uff0c\\u6cb8\\u70b9\\u5929\\u4e0b\\u5f00\\u521b\\u4e86\\u5fae\\u5546\\u884c\\u4e1a\\u7b2c\\u4e00\\u4e2a\\u5c55\\u4f1a\\u2014\\u2014\\u4e2d\\u56fd\\u5fae\\u5546\\u535a\\u89c8\\u4f1a\\uff0c\\u5e76\\u4e8e2015\\u5e74\\u6210\\u529f\\u4e3e\\u884c\\u4e24\\u5c4a\\uff0c\\u8ba9\\u5fae\\u5546\\u5c55\\u4f1a\\u4ece\\u65e0\\u5230\\u6709\\uff0c\\u5e76\\u4e14\\u8d77\\u4e86\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/20\\/348021_230x162_0.jpg\"},{\"news_id\":\"13793\",\"news_title\":\"2016\\u4e2d\\u56fd\\u897f\\u90e8\\u56fd\\u9645\\u4e1d\\u7ef8\\u535a\\u89c8\\u4f1a\",\"news_summary\":\"\\u201c2016\\u5e74\\u4e2d\\u56fd\\u897f\\u90e8\\u56fd\\u9645\\u4e1d\\u7ef8\\u535a\\u89c8\\u4f1a\\u201d\\u6700\\u65b0\\u786e\\u5b9a\\u4e8e2016\\u5e745\\u670811\\u65e5\\u81f315\\u65e5\\u5728\\u5357\\u5145\\u4e3e\\u884c\\u3002\\u636e\\u6089\\uff0c\\u201c\\u4e1d\\u535a\\u4f1a\\u201d\\u7684\\u4f1a\\u5fbd\\u3001\\u4f1a\\u6807\\u53ca\\u5ba3\\u4f20\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/19\\/113912_230x162_0.jpg\"},{\"news_id\":\"13792\",\"news_title\":\"\\u4e2d\\u56fd\\u9488\\u68c9\\u7ec7\\u54c1\\u4ea4\\u6613\\u4f1a\\u5f00\\u62d3\\u201c\\u897f\\u90e8\\u5e02\\u573a\\u201d\",\"news_summary\":\"\\u7531\\u56fd\\u5bb6\\u5546\\u52a1\\u90e8\\u91cd\\u70b9\\u652f\\u6301\\u3001\\u4e2d\\u56fd\\u7eba\\u7ec7\\u54c1\\u5546\\u4e1a\\u534f\\u4f1a\\u4e3b\\u529e\\u7684\\u7b2c98\\u5c4a\\u4e2d\\u56fd\\u9488\\u68c9\\u7ec7\\u54c1\\u4ea4\\u6613\\u4f1a\\u5c06\\u4e8e3\\u670815\\u65e5\\uff5e17\\u65e5\\u7efd\\u653e\\u6210\\u90fd\\u3002\\u4f5c\\u4e3a\\u4e2d\\u56fd\\u56fd\\u5185\\u9488\\u68c9\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/19\\/650175_230x162_0.jpg\"},{\"news_id\":\"13791\",\"news_title\":\"\\u4e50\\u5c71\\u5e02\\u7b2c\\u4e8c\\u5341\\u5c4a\\u623f\\u5730\\u4ea7\\u5c55\\u793a\\u4ea4\\u6613\\u4f1a\\u5f00\\u5e55\",\"news_summary\":\"\\u7f8e\\u4e3d\\u4e50\\u5c71\\uff0c\\u751f\\u6001\\u5b9c\\u5c45\\u3002\\u4eca\\u65e5\\uff0c\\u4e50\\u5c71\\u5e02\\u7b2c\\u4e8c\\u5341\\u5c4a\\u623f\\u5730\\u4ea7\\u5c55\\u793a\\u4ea4\\u6613\\u4f1a\\u5728\\u8be5\\u5e02\\u4e2d\\u5fc3\\u57ce\\u533a\\u4e50\\u5c71\\u5e7f\\u573a\\u5f00\\u5e55\\uff0c\\u5c55\\u4f1a\\u5c06\\u6301\\u7eed\\u52301\\u670824\\u65e5\\u3002\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/19\\/321787_230x162_0.jpg\"},{\"news_id\":\"13790\",\"news_title\":\"2016\\u534e\\u4e2d\\u5c4b\\u9762\\u4e0e\\u5efa\\u7b51\\u9632\\u6c34\\u6280\\u672f\\u5c553\\u6708\\u5373\\u5c06\\u5f00\\u5e55\",\"news_summary\":\"\\u7531\\u6e56\\u5317\\u7701\\u5efa\\u7b51\\u9632\\u6c34\\u534f\\u4f1a\\u8054\\u5408\\u6e56\\u5357\\u3001\\u6cb3\\u5357\\u3001\\u6c5f\\u897f\\u3001\\u5b89\\u5fbd\\u4e94\\u7701\\u5efa\\u7b51\\u9632\\u6c34\\u534f\\u4f1a\\u4e3b\\u529e\\u201c2016\\u7b2c\\u4e8c\\u5c4a\\u534e\\u4e2d\\u5c4b\\u9762\\u4e0e\\u5efa\\u7b51\\u9632\\u6c34\\u6280\\u672f\\u5c55\\u89c8\\u4f1a\\u201d\\u5c06\\u4e8e20\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/19\\/376254_230x162_0.jpg\"},{\"news_id\":\"13789\",\"news_title\":\"2016\\u6d77\\u5357\\u56fd\\u9645\\u65c5\\u6e38\\u8d38\\u6613\\u535a\\u89c8\\u4f1a\\u53ec\\u5f00\\u65b0\\u95fb\\u53d1\\u5e03\\u4f1a\",\"news_summary\":\"\\u8fd1\\u65e5\\uff0c\\u4e09\\u4e9a\\u65c5\\u6e38\\u5b98\\u65b9\\u7f51\\u4ece\\u6d77\\u5357\\u7701\\u201c\\u9996\\u5c4a\\u6d77\\u535a\\u4f1a\\u201d\\u65b0\\u95fb\\u53d1\\u5e03\\u4f1a\\u4e0a\\u83b7\\u6089\\uff0c\\u6d77\\u5357\\u7701\\u201c\\u9996\\u5c4a\\u6d77\\u535a\\u4f1a\\u201d\\u5c06\\u4e8e2016\\u5e743\\u670826\\u65e5\\u81f34\\u67081\\u65e5\\u5728\\u4e09\\u4e9a\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/19\\/958046_230x162_0.jpg\"},{\"news_id\":\"13788\",\"news_title\":\"2016\\u963f\\u91cc\\u5df4\\u5df4\\u00b7\\u8d35\\u5dde\\u5e74\\u8d27\\u8282\\u5c55\\u9500\\u4f1a\\u5f00\\u5e55\",\"news_summary\":\"\\u201c2016\\u963f\\u91cc\\u5df4\\u5df4\\u00b7\\u8d35\\u5dde\\u5e74\\u8d27\\u8282\\u201d\\u7684\\u5c55\\u9500\\u4f1a\\u53ca\\u8fce\\u6625\\u5e99\\u4f1a\\u6628\\u65e5\\u542f\\u52a8\\u3002150\\u591a\\u5bb6\\u9910\\u996e\\u5546\\u53c2\\u4e0e\\u7684\\u7f8e\\u98df\\u8282\\u3001\\u8fd1\\u5343\\u4e2a\\u54c1\\u79cd\\u7ec4\\u6210\\u7684\\u5e74\\u8d27\\u5c55\\u9500\\u4f1a\\u7b49\\uff0c\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/19\\/371688_230x162_0.jpg\"},{\"news_id\":\"13787\",\"news_title\":\"\\u7b2c\\u4e8c\\u5c4a\\u4e2d\\u56fd\\u76c6\\u683d\\u82b1\\u5349\\u4ea4\\u6613\\u4f1a\\u200b \\u672c\\u670828\\u65e5\\u5f00\\u5e55\",\"news_summary\":\"\\u636e\\u5e7f\\u5dde\\u5e02\\u653f\\u5e9c\\u83b7\\u6089\\uff0c\\u7ecf\\u4e2d\\u56fd\\u82b1\\u5349\\u534f\\u4f1a\\u548c\\u5e7f\\u5dde\\u5e02\\u653f\\u5e9c\\u6279\\u51c6\\uff0c\\u7b2c\\u4e8c\\u5c4a\\u4e2d\\u56fd\\u76c6\\u683d\\u82b1\\u5349\\u4ea4\\u6613\\u4f1a\\u5c06\\u4e8e\\u672c\\u670828\\u65e5\\u81f331\\u65e5\\u5728\\u5e7f\\u5dde\\u82b1\\u5349\\u535a\\u89c8\\u56ed\\u4e3e\\u884c\\u3002\\u5c4a\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/18\\/687647_230x162_0.jpg\"},{\"news_id\":\"13786\",\"news_title\":\"\\u674e\\u76ca\\uff1a\\u89c6\\u91ce\\u3001\\u54c1\\u8d28\\u3001\\u878d\\u5408\\u662f\\u5c55\\u89c8\\u5de5\\u7a0b\\u56fd\\u9645\\u5316\\u7684\\u5fc5\\u7531\\u8def\\u5f84\",\"news_summary\":\"\\u201c\\u89c6\\u91ce\\u3001\\u54c1\\u8d28\\u3001\\u878d\\u5408\\u662f\\u4e2d\\u56fd\\u5c55\\u89c8\\u5de5\\u7a0b\\u8d70\\u5411\\u56fd\\u9645\\u5316\\u7684\\u5fc5\\u7531\\u8def\\u5f84\\u3002\\u201d\\u5317\\u4eac\\u9038\\u683c\\u5929\\u9a84\\u56fd\\u9645\\u5c55\\u89c8\\u6709\\u9650\\u516c\\u53f8\\u526f\\u603b\\u7ecf\\u7406\\u674e\\u76ca\\u65e5\\u524d\\u5728\\u7b2c\\u4e8c\\u5341\\u4e8c\\u5c4a\\u56fd\\u9645(\\u5e38\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/18\\/343556_230x162_0.jpg\"},{\"news_id\":\"13785\",\"news_title\":\"\\u7b2c\\u516b\\u5c4a\\u4e2d\\u56fd\\u56fd\\u9645\\u96c6\\u6210\\u4f4f\\u5b85\\u4ea7\\u4e1a\\u535a\\u89c8\\u4f1a\\u5c06\\u4e8e5\\u6708\\u5728\\u5e7f\\u5dde\\u4e3e\\u529e\",\"news_summary\":\"2016\\u5e741\\u670814\\u65e5\\uff0c\\u7b2c\\u516b\\u5c4a\\u4e2d\\u56fd(\\u5e7f\\u5dde)\\u56fd\\u9645\\u96c6\\u6210\\u4f4f\\u5b85\\u4ea7\\u4e1a\\u535a\\u89c8\\u4f1a\\u66a82016\\u4e9a\\u592a\\u5efa\\u7b51\\u79d1\\u6280\\u8bba\\u575b\\u2014\\u2014\\u65b0\\u95fb\\u53d1\\u5e03\\u4f1a\\u5728\\u5e7f\\u5dde\\u9986\\u9686\\u91cd\\u53ec\\u5f00\\u3002\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/18\\/581830_230x162_0.jpg\"},{\"news_id\":\"13784\",\"news_title\":\"\\u4e1d\\u7ef8\\u4e4b\\u8def\\u6566\\u714c\\u56fd\\u9645\\u6587\\u5316\\u535a\\u89c8\\u4f1a\\u7b79\\u5907\\u5de5\\u4f5c\\u8fdb\\u5c55\\u987a\\u5229\",\"news_summary\":\"\\u8fd1\\u65e5\\uff0c\\u4e1d\\u7ef8\\u4e4b\\u8def(\\u6566\\u714c)\\u56fd\\u9645\\u6587\\u5316\\u535a\\u89c8\\u4f1a\\u7ec4\\u59d4\\u4f1a\\u7b2c\\u4e8c\\u6b21\\u4f1a\\u8bae\\u5728\\u5170\\u53ec\\u5f00\\u3002\\u4f1a\\u8bae\\u7814\\u7a76\\u8ba8\\u8bba\\u4e86\\u7701\\u76f4\\u5385\\u5c40\\u4e00\\u5bf9\\u4e00\\u670d\\u52a1\\u4fdd\\u969c\\u6cbf\\u7ebf\\u7701\\u533a\\u5e02\\u65b9\\u6848\\u3001\\u6587\\u535a\\u4f1a\",\"pic_url\":\"http:\\/\\/f.expoon.com\\/sub\\/news\\/2016\\/01\\/18\\/656693_230x162_0.jpg\"}]}";
    List<News.DataBean> data = new ArrayList<>();
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.recycler);
//        btn = (Button) findViewById(R.id.button);
//        btn1 = (Button) findViewById(R.id.button2);
//        btn.setOnClickListener(this);
//        btn1.setOnClickListener(this);
//        News news = new News();

//        int i=1;
//        news_title = data.get(i).getNews_title();
//        s = news_title.toString();
        File file = new File("/mnt/sdcard/cxtf.txt");
//        switch (view.getId()) {
//            case R.id.button:
        try {
            file.createNewFile();
            //实例化一个输出流
            FileOutputStream out = new FileOutputStream(file);
            //FileOutputStream out=new FileOutputStream("/mnt/sdcard/cxy.txt");
            //把文字转化为字节数组
            byte[] bytes = s.getBytes();
            //写入字节数组到文件
            out.write(bytes);
            //关闭输入流
            out.close();
            Toast.makeText(MainActivity.this, "写入成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
//                break;
//            case R.id.button2:
        try {
            String text = null;
            //实例化一个输入流
            FileInputStream input = new FileInputStream(file);
            //把文件中的所有内容转换为byte字节数组
            byte[] bytes = new byte[input.available()];
            //读取内容
            input.read(bytes);
            //关闭输入流
            input.close();
            //把bytes字节数组转化为文字
            text = new String(bytes);
            News news = new Gson().fromJson(text, News.class);
            data.addAll(news.getData());
            Toast.makeText(MainActivity.this, data.get(0).getNews_title(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new Myadapter());


    }

    class Myadapter extends RecyclerView.Adapter {


        private View inflate;
        private MyViewHolder myViewHolder;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            myViewHolder = (MyViewHolder) holder;
            myViewHolder.textView.setText(data.get(position).getNews_title());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {


            private final TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.text);


            }
        }


    }

}

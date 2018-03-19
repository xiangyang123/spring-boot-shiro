import com.neo.SpringBootShiroApplication;
//import com.neo.dao.ArticleDao;
//import com.neo.entity.Article;
//import com.neo.entity.Author;
//import com.neo.entity.Tutorial;
//import org.apache.commons.collections.IteratorUtils;
//import org.elasticsearch.action.admin.indices.analyze.AnalyzeAction;
//import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
//import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
//import org.elasticsearch.index.query.QueryStringQueryBuilder;
//import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.query.Criteria;
//import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * Created by zouxiang on 2017/10/26.
// */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootShiroApplication.class)
public class ElasticSearchTest {
//
//    @Autowired
//    private ArticleDao articleDao;
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//    @Test
//    public void testSaveArticleIndex(){
//        Author author=new Author();
//        author.setId(1L);
//        author.setName("tianshouzhi");
//        author.setRemark("java developer");
//
//        Tutorial tutorial=new Tutorial();
//        tutorial.setId(1L);
//        tutorial.setName("elastic search");
//
//        for(int i=0;i<10;i++){
//            Article article1 = new Article();
//            article1.setId((long)i);
//            article1.setTitle("springboot书籍" +i);
//            article1.setAbstracts("springboot的书" + i);
//            article1.setTutorial(tutorial);
//            article1.setAuthor(author);
//            article1.setContent("elasticsearch based on lucene" + i);
//            article1.setPostTime(new Date());
//            article1.setClickCount((long)i);
//            articleDao.save(article1);
//        }
//        for(int i=10;i<20;i++){
//            Article article1 = new Article();
//            article1.setId((long)i);
//            article1.setTitle("蓝月亮指的导手册" +i);
//            article1.setAbstracts("蓝月亮指导手册的书" + i);
//            article1.setTutorial(tutorial);
//            article1.setAuthor(author);
//            article1.setContent("蓝月亮书中自有黄金屋" + i);
//            article1.setPostTime(new Date());
//            article1.setClickCount((long)i);
//            articleDao.save(article1);
//        }
//        for(int i=20;i<30;i++){
//            Article article1 = new Article();
//            article1.setId((long)i);
//            article1.setTitle("编程的世界" +i);
//            article1.setAbstracts("机洗至尊" + i);
//            article1.setTutorial(tutorial);
//            article1.setAuthor(author);
//            article1.setContent("编程思想的博客好屌" + i);
//            article1.setPostTime(new Date());
//            article1.setClickCount((long)i);
//            articleDao.save(article1);
//        }
//        for(int i=30;i<40;i++){
//            Article article1 = new Article();
//            article1.setId((long)i);
//            article1.setTitle("外国的月亮" +i);
//            article1.setAbstracts("美国的月亮" + i);
//            article1.setTutorial(tutorial);
//            article1.setAuthor(author);
//            article1.setContent("伊拉克的太阳" + i);
//            article1.setPostTime(new Date());
//            article1.setClickCount((long)i);
//            articleDao.save(article1);
//        }
//        for(int i=40;i<50;i++){
//            Article article1 = new Article();
//            article1.setId((long)i);
//            article1.setTitle("床前明月光" +i);
//            article1.setAbstracts("疑是地上霜" + i);
//            article1.setTutorial(tutorial);
//            article1.setAuthor(author);
//            article1.setContent("李白--静夜思" + i);
//            article1.setPostTime(new Date());
//            article1.setClickCount((long)i);
//            articleDao.save(article1);
//        }
//        for(int i=50;i<60;i++){
//            Article article1 = new Article();
//            article1.setId((long)i);
//            article1.setTitle("亮晶晶" +i);
//            article1.setAbstracts("好亮啊" + i);
//            article1.setTutorial(tutorial);
//            article1.setAuthor(author);
//            article1.setContent("白白亮亮" + i);
//            article1.setPostTime(new Date());
//            article1.setClickCount((long)i);
//            articleDao.save(article1);
//        }
//    }
//
//    @Test
//    public void testSearch(){
//        String queryString="编程的";//搜索关键字
//        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(queryString);
//        Iterable<Article> searchResult = articleDao.search(builder);
//        Iterator<Article> iterator = searchResult.iterator();
//        while(iterator.hasNext()){
//            System.out.println("elasticsearch 搜索结果---"+iterator.next());
//        }
//    }
//
//    @Test
//    public void testSize(){
//        Iterable iterable = articleDao.findAll();
//        List list = IteratorUtils.toList(iterable.iterator());
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void testSearchPage(){
//        String queryString="springboot";//搜索关键字
//        Pageable pageable = new PageRequest(0,5);
//        Page<Article> searchResult = articleDao.findByTitle(queryString,pageable);
//        System.out.println("elasticsearch 搜索结果---"+searchResult.getContent());
//    }
//
//    @Test
//    public void getListIkAnalyzeSearchTerms(){
//        //排序
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        //分页
//        Pageable pageable = new PageRequest(0,50, sort);
//
//        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria("title").contains("蓝月亮"));
//
////        long count = elasticsearchTemplate.count(criteriaQuery);
////        System.out.println(count);
//
//        criteriaQuery.setPageable(pageable);
//        // when
//        List<Article> article = elasticsearchTemplate.queryForList(criteriaQuery, Article.class);
//        System.out.println(article);
////        assertThat(article.size(), is(0));
//    }
//
//
////    /**
////     * 缺少IK 分词器
////     */
////    @Test
////    public void getIkAnalyzeSearchTerms(){
////        // 调用 IK 分词分词
////        AnalyzeRequestBuilder ikRequest = new AnalyzeRequestBuilder(elasticsearchTemplate.getClient(),
////                AnalyzeAction.INSTANCE,"projectname","蓝月亮");
////        ikRequest.setTokenizer("ik");
////        List<AnalyzeResponse.AnalyzeToken> ikTokenList = ikRequest.execute().actionGet().getTokens();
////        for(AnalyzeResponse.AnalyzeToken analyzeToken :ikTokenList){
////            System.out.println("IK 分词-----" + analyzeToken.getTerm());
////        }
////
////    }
}

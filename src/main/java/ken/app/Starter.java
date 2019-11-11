package ken.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan(basePackages= {"ken.app.dao"}) //要扫描mapper类包的路径
@ComponentScan(basePackages ={"ken.app"})
@SpringBootApplication
@EnableTransactionManagement
public class Starter {
	
	public static void main(String[] args) {
		//调用spring应用的run方法,将根据自动配置,默认配置,完成初始化的创建,根据依赖完成
		//所有功能的自动配置
		SpringApplication.run(Starter.class,  args);
	}  
	
	
}

# 1.环境条件

JDK=21
Maven=3.9

# 2. maven 配置文件setting.xml内容
有的包，阿里云仓库里可能没有
	<mirror>
		<id>aliyun</id>
		<name>Aliyun Maven</name>
		<mirrorOf>*,!spring-milestones</mirrorOf>
		<url>https://maven.aliyun.com/nexus/content/groups/public</url>
	</mirror>


 	<profile>
      <id>jdk-21</id>
      <activation>
        <jdk>21</jdk>
      </activation>
      <repositories>
        <repository>
          <id>spring-milestones</id>
          <name>Spring Milestones</name>
          <url>http://repo.spring.io/milestones</url>
          <snapshot>
			<enabled>false</enabled>
		  </snapshot>
        </repository>
      </repositories>
    </profile>

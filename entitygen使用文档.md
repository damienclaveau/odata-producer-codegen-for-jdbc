���:olingo-odata-jpa-entitygen ���Զ�����jpa Entity����Ĺ���.ʹ����������jpa-api/jpa-core/sql-driver.������ʹ��olingo2-odata2-jpa2��ʵ��odata2��¶��ʱ��,��Ҫ
�ֶ����������ݿ���Ӧ��Entity,������ݿ������ϰ��ű�,������ʹ��olingo-odata-jpa-entitygen��ʵ���Զ�����Entity�ͺܷ�����.

ʹ�ò���:
   һ:����һ������olingo2-odata2-jpa2������Ӧ��

   ��:��olingo-odata-jpa-entitygen.jar�ܰ��������̵�classPath��.

   ��:����tomcat����ʱ��CLASSPATH=H:\apache-tomcat-7.0.52\webapps\TokyoSubway\WEB-INF\lib\*.jar(��ΪӦ����������ʱ����Entity��,����CLASSPATH������Ӧ�õ�lib,TokyoSubway�ǹ�����)


   ��:����web.xml
       <servlet>
             <servlet-name>EntityServlet</servlet-name>
             <servlet-class>olingo.odata.jpa.entitygen.servlet.EntityServlet</servlet-class>
             <init-param>
                  <param-name>persistence.UnitName</param-name>
                  <param-value>odata2_jpa2</param-value>
             </init-param>
	     <init-param>
                  <param-name>persistence.ClassPath</param-name>
                  <param-value>persistence.xml</param-value>
             </init-param>
       </servlet>

       <servlet-mapping>
             <servlet-name>EntityServlet</servlet-name>
             <url-pattern>/EntityServlet/*</url-pattern>
       </servlet-mapping>

       EntityServlet���Զ�����Entity�����.
       persistence.UnitName������persistence.xml������ʹ�õ�UnitName.
       persistence.ClassPath������persistence.xml��·��������,Ĭ���Ǳ�����META-INF/persistence.xml(�����Ĭ�ϵ�·�������ƵĻ�,���Բ���ָ���ò���).


     ��:persistence.xml��persistence-unit������
        <?xml version="1.0" encoding="UTF-8" standalone="no"?><persistence xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.0" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	<persistence-unit name="odata2_jpa2" transaction-type="RESOURCE_LOCAL">
		<provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
        <properties>  
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://127.0.0.1:3306/TS"/>  
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>  
            <property name="javax.persistence.jdbc.user" value="root"/>  
            <property name="javax.persistence.jdbc.password" value="password"/>  
        </properties> 	
	</persistence-unit>
        </persistence>



ʹ��sample���ٴ�Լ���olingo2-odata2-jpa2����
    ����
    1,��Ӧ��TokyoSubway��������IDE������
    2,�޸�persistence.xml�����ݿ�����
    3,����tomcat�����ǵ�CLASSPATH=H:\apache-tomcat-7.0.52\webapps\TokyoSubway\WEB-INF\lib\*.jar;  (ָ��Ӧ�ò���ʱ��lib����jar�ļ�)
    4,startup server
    5,http://localhost:8080/TokyoSubway/EntityServlet   ִ���Զ�����Entity�������
    6,����ȷ����:
        STATE:OK
        Application[/TokyoSubway] auto create entity is successed.Please manually restart the application!
    7,restart server
    8,http://localhost:8080/TokyoSubway/OdataServlet.cn    �������ݿ��е����б�����ݶ����Ա�¶������.




�����ֻ�뱩¶���ݿ��еĲ�������
    ʵ�ֲ���
    1,���������ݿ��д���һ����ΪOling_Odata_JPA_ExposeTable�ı�
      drop table if exists Oling_Odata_JPA_ExposeTable;
      create table Oling_Odata_JPA_ExposeTable(
        ExposeTableName varchar(50) primary key        #��Ҫ��¶�ı���
      );

    ����olingo-odata-jpa-entitygen����ʶ������ExposeTableName��Ӧ��Entity
    ������ݿ���û��Oling_Odata_JPA_ExposeTable�����г���Ϊ0��olingo-odata-jpa-entitygen��Ĭ���Ǳ�¶ȫ�����ݿ��.



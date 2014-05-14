one-ear-multiple-wars-share-spring-contexts
===========================================

inside one ear many war share the common spring context

reference: 
http://imranbohoran.blogspot.com/2011/02/multiple-web-applications-one-spring.html
http://spring.io/blog/2007/06/11/using-a-shared-parent-application-context-in-a-multi-war-spring-application/

Task List:
1. modify web.xml war
  add: 
  	<context-param>
	    <param-name>locatorFactorySelector</param-name>
	    <!--  beanrefContext.xml is the default, if you use that this block is unnecessary-->
	    <param-value>classpath:common-beans.xml</param-value> 
	</context-param> 

2. in common-beans.xml
    <!-- This bean is the parent ApplicationContext for the WebApplicationContexts defined in the WARs. 
         The context files listed here should contain beans that are used by all WARs, 
         for example Services and DAO's. -->
    <bean id="ear.context" class="org.springframework.context.support.ClassPathXmlApplicationContext">
        <constructor-arg>
            <list>
                <value>services-context1.xml</value>
                <value>services-context2.xml</value>
                  ...
                <value>services-contextN.xml</value>
            </list>
        </constructor-arg>
    </bean>

	3. if use servlet 3 spring, in WebApplicationInitializer
	use
		sc.setInitParameter("parentContextKey", "ear.context");
		sc.setInitParameter("locatorFactorySelector", "classpath:common-beans.xml");

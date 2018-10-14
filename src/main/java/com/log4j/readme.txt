1.配置文件
#可以设置级别：debug>info>error
#debug：显示debug、info、error
#info：显示info、error
#error：只error
log4j.rootLogger=debug,appender1
#log4j.rootLogger=info,appender1
#log4j.rootLogger=error,appender1

#输出到控制台
log4j.appender.appender1=org.apache.log4j.ConsoleAppender
#样式为TTCCLayout
log4j.appender.appender1.layout=org.apache.log4j.TTCCLayout

2.输出为文本文件或HTML文件
#设置级别：
log4j.rootLogger=debug,appender1

#输出到文件(这里默认为追加方式)
log4j.appender.appender1=org.apache.log4j.FileAppender
#设置文件输出路径
#【1】文本文件
#log4j.appender.appender1.File=c:/Log4JDemo02.log
#【2】HTML文件
log4j.appender.appender1.File=c:/Log4JDemo02.html
#设置文件输出样式
#log4j.appender.appender1.layout=org.apache.log4j.TTCCLayout
log4j.appender.appender1.layout=org.apache.log4j.HTMLLayout

3.设置级别和多个目的地  
#设置级别和多个目的地
log4j.rootLogger=debug,appender1,appender2

#输出到控制台
log4j.appender.appender1=org.apache.log4j.ConsoleAppender
#设置输出样式
log4j.appender.appender1.layout=org.apache.log4j.TTCCLayout

#输出到文件(这里默认为追加方式)
log4j.appender.appender2=org.apache.log4j.FileAppender
#设置文件输出路径
#【1】文本文件
#log4j.appender.appender2.File=c:/Log4JDemo02.log
#【2】HTML文件
log4j.appender.appender2.File=c:/Log4JDemo02.html
#设置文件输出样式
#log4j.appender.appender2.layout=org.apache.log4j.TTCCLayout
log4j.appender.appender2.layout=org.apache.log4j.HTMLLayout

4.SimpleLayout样式
#设置级别和目的地
log4j.rootLogger=debug,appender1

#输出到控制台
log4j.appender.appender1=org.apache.log4j.ConsoleAppender
#设置输出样式
log4j.appender.appender1.layout=org.apache.log4j.SimpleLayout

5.自定义样式
#设置级别和目的地
log4j.rootLogger=debug,appender1

#输出到控制台
log4j.appender.appender1=org.apache.log4j.ConsoleAppender
#设置输出样式
log4j.appender.appender1.layout=org.apache.log4j.PatternLayout
#自定义样式
# %r 时间 0
# %t 方法名 main
# %p 优先级 DEBUG/INFO/ERROR
# %c 所属类的全名(包括包名)
# %l 发生的位置，在某个类的某行
# %m 输出代码中指定的讯息，如log(message)中的message
# %n 输出一个换行

log4j.appender.appender1.layout.ConversionPattern=%r [%t] [%p] - %c -%l -%m%n


6.多目的地、自定义样式
#设置级别和目的地
log4j.rootLogger=debug,appender1,appender2

#输出到控制台
log4j.appender.appender1=org.apache.log4j.ConsoleAppender
#设置输出样式
log4j.appender.appender1.layout=org.apache.log4j.PatternLayout
#自定义样式
# %r 时间 0
# %t 方法名 main
# %p 优先级 DEBUG/INFO/ERROR
# %c 所属类的全名(包括包名)
# %l 发生的位置，在某个类的某行
# %m 输出代码中指定的讯息，如log(message)中的message
# %n 输出一个换行符号
log4j.appender.appender1.layout.ConversionPattern=[%d{yy/MM/dd HH:mm:ss:SSS}][%C-%M] %m%n

#输出到文件(这里默认为追加方式)
log4j.appender.appender2=org.apache.log4j.FileAppender
#设置文件输出路径
#【1】文本文件
log4j.appender.appender2.File=c:/Log4JDemo06.log
#设置文件输出样式
log4j.appender.appender2.layout=org.apache.log4j.PatternLayout
log4j.appender.appender2.layout.ConversionPattern=[%d{HH:mm:ss:SSS}][%C-%M] -%m%n


7.企业应用】设置 特定包的级别和目的地
#省略根，只设置特定包的级别和目的地
log4j.logger.com.coderdream.log4j=debug,appender1
log4j.logger.com.coderdream.log4jDao=info,appender1,appender2

#输出到控制台
log4j.appender.appender1=org.apache.log4j.ConsoleAppender
#设置输出样式
log4j.appender.appender1.layout=org.apache.log4j.PatternLayout
#自定义样式
# %r 时间 0
# %t 方法名 main
# %p 优先级 DEBUG/INFO/ERROR
# %c 所属类的全名(包括包名)
# %l 发生的位置，在某个类的某行
# %m 输出代码中指定的讯息，如log(message)中的message
# %n 输出一个换行符号
log4j.appender.appender1.layout.ConversionPattern=[%d{yy/MM/dd HH:mm:ss:SSS}][%C-%M] %m%n

#输出到文件(这里默认为追加方式)
log4j.appender.appender2=org.apache.log4j.FileAppender
#设置文件输出路径
#【1】文本文件
log4j.appender.appender2.File=c:/Log4JDemo07_Dao.log
#设置文件输出样式
log4j.appender.appender2.layout=org.apache.log4j.PatternLayout
log4j.appender.appender2.layout.ConversionPattern=[%d{HH:mm:ss:SSS}][%C-%M] -%m%n

8.log4j.xml的配置方式
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

	<appender name="appender1"
		class="org.apache.log4j.RollingFileAppender">
		<param name="File" value="logfile08.html" />
		<param name="MaxFileSize" value="1MB" />
		<param name="MaxBackupIndex" value="5" />
		<layout class="org.apache.log4j.HTMLLayout">
		</layout>
	</appender>

	<root>
		<level value="debug" />
		<appender-ref ref="appender1" />
	</root>
</log4j:configuration>



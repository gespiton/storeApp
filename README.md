**目录**

*  setup Project
*  deploy project




#setup Project

##install maven
* check the official [site](https://maven.apache.org/install.html)
	* download the package, put it the place you like, extract it
	* add the **the dir contain mvn** to $PATH
	* make sure **JAVA_HOME** is in environment variable
	* run **mvn -version** you should see this
		
		```
		Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T00:41:47+08:00)
		Maven home: /Users/sher/marven/apache-maven-3.3.9
		Java version: 1.8.0_121, vendor: Oracle Corporation
		Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre
		Default locale: en_US, platform encoding: UTF-8
		OS name: "mac os x", version: "10.11.6", arch: "x86_64", family: "mac"
		```
	* congratulation, you success

##import to IDE

* ###Intellij
  import project -> open your dir contain pom.xml -> 
  
  ![](./pic/1.png)
  
  -> all the way Next, after you see the project load up, on the left click marven
  
  ![](./pic/2.png)
  
  -> that's it
  
  ![](./pic/3.png)
  
  -> full IDE view
  
  ![](./pic/4.png)
  
* ###Eclipse
 
  File -> import -> Maven/Existing Maven Projects  -> 
  
  ![](./pic/5.png)
  
  ![](./pic/6.png)
  
  ok, that's it
  
  here is a [Youtube Tutorial](https://www.youtube.com/watch?v=0CFWeVgzsqY) about maven
  
---


  
#deploy project
* 在项目目录运行 mvn clean install，会在 target 文件夹下生成 war 文件
* 浏览器输入 gespiton/manager
* user： sher     password: freedom
* 在下面找到 chosefile 选项，上传war文件，查看上面的app列表，看到上传的文件，则成功发布
* 浏览器输入 gespiton.cn/war文件名

  
  
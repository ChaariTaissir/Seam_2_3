Seam SeamBay Example
====================

This example shows Seam/WS integration. It runs on JBoss AS as an EAR and
JBoss with Embedded JBoss as a WAR.

To deploy the example to JBoss AS, follow these steps:

* In the example root directory run:

    mvn clean package

* Set JBOSS_HOME environment property.

* In the seambay-ear directory run:

    mvn jboss:hard-deploy

* Open this URL in a web browser: http://localhost:8080/seam-seambay

To deploy the example to Tomcat with Embedded JBoss, follow these steps:

* In the example root directory run:

    mvn clean package -Ptomcat

* Deploy the resulting war from seambay-web/target directory to Tomcat manually

* Open this URL in a web browser: http://localhost:8080/jboss-seam-seambay

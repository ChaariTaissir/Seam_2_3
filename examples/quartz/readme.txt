Seam Quartz Example
===================

This example demonstrates the Seam Quartz Timer functionality. It runs on JBoss
AS as an EAR.

To deploy the example to JBoss AS, follow these steps:

* In the example root directory run:

    mvn clean package

* Set JBOSS_HOME environment property.

* In the quartz-ear directory run:

    mvn jboss:hard-deploy

* Open this URL in a web browser: http://localhost:8080/seam-quartz

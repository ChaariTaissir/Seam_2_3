package com.jboss.dvd.seam.test;

import java.io.File;
import java.math.BigDecimal;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jboss.dvd.seam.StoreManager;

@RunWith(Arquillian.class)
public class StoreManagerTest 
   extends JUnitSeamTest
{
   
   @Deployment(name = "StoreManagerTest")
   @OverProtocol("Servlet 3.0")
   public static Archive<?> createDeployment()
   {
      EnterpriseArchive er = ShrinkWrap.create(ZipImporter.class, "seam-dvdstore.ear").importFrom(new File("../dvdstore-ear/target/seam-dvdstore.ear")).as(EnterpriseArchive.class);
      WebArchive web = er.getAsType(WebArchive.class, "dvdstore-web.war");
      web.addClasses(StoreManagerTest.class);

      return er;
   }
   
    @Test
    public void testTopProducts() 
        throws Exception
    {
        
        new FacesRequest() {
            StoreManager manager;
            @Override
            protected void updateModelValues()
            {
                manager = (StoreManager) getInstance("stats");
            }
            @Override
            protected void renderResponse()
            {
                // these are from order instances - 
                Assert.assertEquals("number orders",   0L,    manager.getNumberOrders());
                Assert.assertEquals("total sales",     BigDecimal.ZERO,   manager.getTotalSales());

                // these are from inventory
                Assert.assertEquals("units sold",      5734,  manager.getUnitsSold());
                Assert.assertEquals("total inventory", 23432, manager.getTotalInventory());
            }               
        }.run();
    }

}

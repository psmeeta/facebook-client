package org.chrise.facebook.model;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.chrise.facebook.Facebook;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class FacebookTest
{
    private static final String userName = "ceva24";
    private static final String pageName = "cocacola";
    
    private Facebook facebook;
    
    public FacebookTest() {}

    @Before
    public void setUp()
    {
        try
        {
            facebook = new Facebook();
        }
        catch (KeyManagementException | NoSuchAlgorithmException e)
        {
            System.err.println("Failed to create Facebook client. Cause: " + e.getMessage());
            System.exit(0);
        }
    }

    @Test
    public void testGetNameForId()
    {
        String name = facebook.getNameForId(userName);
        assertEquals("Unexpected username value returned", "Christian Evans", name);
    }
    
    @Test
    public void testGetLikes()
    {
        List<FacebookObject> likes = facebook.getLikes(pageName);
        assertTrue("No data returned", likes.size() > 0);
    }
    
    @Test
    public void testGetSixDegrees()
    {
        FacebookObject[] degrees = facebook.getSixDegrees(pageName);
        
        assertEquals("Unexpected array length", 6, degrees.length);
        assertFalse("Control object " + pageName + " returned no likes", degrees[0] == null);
    }
}
package org.chrise.facebook.model;

public class FacebookObject
{
    private final String id;
    private final String name;
    
    public FacebookObject(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return id + ", " + name;
    }
}
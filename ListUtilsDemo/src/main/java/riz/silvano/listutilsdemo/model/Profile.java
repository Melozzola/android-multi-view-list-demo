package riz.silvano.listutilsdemo.model;

import java.net.URL;

/**
 * Created by mele on 11/10/2013.
 */
public class Profile
{
    private String name;
    private String location;
    private String coverImgUrl;
    private String profileImgUrl;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getCoverImgUrl()
    {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl)
    {
        this.coverImgUrl = coverImgUrl;
    }

    public String getProfileImgUrl()
    {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl)
    {
        this.profileImgUrl = profileImgUrl;
    }
}

package com.example.kamps.ui.policies;

public class PoliciesClass {

    private String policy_name;
    private String policy_description;
    private String policy_image_id;
    private String visit_us;

    public PoliciesClass(String p_name,String p_description,String p_image_id,String v_us)
    {
        policy_name=p_name;
        policy_description=p_description;
        policy_image_id=p_image_id;
        visit_us=v_us;
    }

    public String getPolicy_name()
    {return  policy_name;}

    public String getPolicy_description()
    {return policy_description;}

    public String getPolicy_image_id()
    {return policy_image_id;}

    public String getVisit_us()
    {return visit_us;}

    public void setPolicy_name(String p_name)
    {policy_name=p_name;}

    public void setPolicy_description(String p_description)
    {policy_description=p_description;}

    public void setPolicy_image_id(String p_image_id)
    {policy_image_id=p_image_id;}

    public void setVisit_us(String v_us)
    {visit_us=v_us;}
}

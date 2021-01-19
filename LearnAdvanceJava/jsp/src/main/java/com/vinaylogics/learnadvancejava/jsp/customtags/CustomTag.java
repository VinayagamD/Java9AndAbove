package com.vinaylogics.learnadvancejava.jsp.customtags;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CustomTag extends TagSupport {
    private static final long serialVersionUID = 4843510023283862337L;

    private String inputString;
    private String lookupString;
    /**
     * @return the inputString
     */
    public String getInputString() {
        return inputString;
    }
    /**
     * @param inputString the inputString to set
     */
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
    /**
     * @return the lookupString
     */
    public String getLookupString() {
        return lookupString;
    }
    /**
     * @param lookupString the lookupString to set
     */
    public void setLookupString(String lookupString) {
        this.lookupString = lookupString;
    }
    @Override
    public int doStartTag() throws JspException {

        try {
            JspWriter out = pageContext.getOut();
            out.println("<p>");
            out.println(StringUtils.countMatches(inputString, lookupString) == 1);
            out.println("</p>");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }
}

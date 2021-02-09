/**
 * 
 */
package com.ivoslabs.mail.comp;

import com.google.gson.JsonObject;
import com.ivoslabs.mail.comp.hbs.HTMLParams;

/**
 * @since
 * @author  
 *
 */
public interface HBSTemplates {
    
    String compile(Enum<?> template, HTMLParams model);
    
    HTMLParams createModel(JsonObject json) ;

}

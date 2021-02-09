/**
 * 
 */
package com.ivoslabs.mail.comp;

import org.springframework.stereotype.Component;

import com.ivoslabs.mail.comp.hbs.LabelSupplier;

/**
 * @since
 * @author
 *
 */
@Component
public class LabelSupplierImpl implements LabelSupplier {

    /*
     * (non-Javadoc)
     * 
     * @see com.ivoslabs.mail.comp.hbs.LabelSupplier#getLabelFor(java.lang.String)
     */
    @Override
    public String getLabelFor(String labelKey) {
        return "<i>" + labelKey + "</i>";
    }

}

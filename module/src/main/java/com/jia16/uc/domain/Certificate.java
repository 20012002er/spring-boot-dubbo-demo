package com.jia16.uc.domain;

import java.io.Serializable;

/**
 * Created by lazyb on 2017/6/22.
 */
public class Certificate implements Serializable {

    private String certificateName;
    private String certificateIdentity;

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateIdentity() {
        return certificateIdentity;
    }

    public void setCertificateIdentity(String certificateIdentity) {
        this.certificateIdentity = certificateIdentity;
    }
}

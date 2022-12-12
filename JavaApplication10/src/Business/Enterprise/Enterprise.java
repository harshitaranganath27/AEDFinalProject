/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Network.Network;
import Business.Org.Organization;
import Business.Org.organizationDir;

/**
 *
 * @author
 */
public abstract class Enterprise extends Organization {

    private enterprseType type;
    private organizationDir orgDirectory;
    private Network network;

    public Network getNetwork() {
        return this.network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public organizationDir getOrgDirectory() {
        return orgDirectory;
    }

    public enum enterprseType {
        Hospital("Hospital"),
        Pharmacy("Pharmacy"),
        Lab("Lab"),
        Insurance("Insurance");

        private String value;

        private enterprseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enterprseType getType() {
        return type;
    }

    public void setType(enterprseType type) {
        this.type = type;
    }

    public Enterprise(String name, enterprseType type) {
        super(name);
        this.type = type;
        orgDirectory = new organizationDir();
    }

    @Override
    public String toString() {
        return this.getName();
    }

}

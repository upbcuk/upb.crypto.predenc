package de.upb.crypto.predenc.kem.abe.cp.large;

import de.upb.crypto.craco.abe.cp.large.ABECPWat11PublicParameters;
import de.upb.crypto.craco.common.de.upb.crypto.craco.interfaces.CipherText;
import de.upb.crypto.craco.common.de.upb.crypto.craco.interfaces.policy.Policy;
import de.upb.crypto.math.structures.groups.GroupElement;
import de.upb.crypto.math.serialization.Representable;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.annotations.ReprUtil;
import de.upb.crypto.math.serialization.annotations.Represented;

import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;

public class ABECPWat11KEMCipherText implements CipherText, Representable {

    @Represented
    protected Policy policy;

    @Represented(restorer="G1")
    protected GroupElement eTwoPrime; // in G_1

    @Represented(restorer="int -> G1")
    protected Map<BigInteger, GroupElement> eElementMap; // in G_1

    public ABECPWat11KEMCipherText(Policy policy, GroupElement eTwoPrime, Map<BigInteger, GroupElement> eElementMap) {
        this.policy = policy;
        this.eTwoPrime = eTwoPrime;
        this.eElementMap = eElementMap;
    }

    public ABECPWat11KEMCipherText(Representation repr, ABECPWat11PublicParameters pp) {
        new ReprUtil(this).register(pp.getGroupG1(), "G1").deserialize(repr);
    }

    public ABECPWat11KEMCipherText() {
    }

    public Policy getPolicy() {
        return policy;
    }

    public GroupElement getETwoPrime() {
        return eTwoPrime;
    }

    public Map<BigInteger, GroupElement> getE() {
        return eElementMap;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eElementMap == null) ? 0 : eElementMap.hashCode());
        result = prime * result + ((eTwoPrime == null) ? 0 : eTwoPrime.hashCode());
        result = prime * result + ((policy == null) ? 0 : policy.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ABECPWat11KEMCipherText other = (ABECPWat11KEMCipherText) obj;
        return Objects.equals(eElementMap, other.eElementMap)
                && Objects.equals(eTwoPrime, other.eTwoPrime)
                && Objects.equals(policy, other.policy);
    }

    @Override
    public Representation getRepresentation() {
        return ReprUtil.serialize(this);
    }

    @Override
    public String toString() {
        return getRepresentation().toString();
    }
}
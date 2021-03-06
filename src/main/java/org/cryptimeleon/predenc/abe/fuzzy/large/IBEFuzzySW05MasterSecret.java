package org.cryptimeleon.predenc.abe.fuzzy.large;

import org.cryptimeleon.math.serialization.Representation;
import org.cryptimeleon.math.serialization.annotations.ReprUtil;
import org.cryptimeleon.math.serialization.annotations.Represented;
import org.cryptimeleon.math.structures.rings.zn.Zp;
import org.cryptimeleon.math.structures.rings.zn.Zp.ZpElement;
import org.cryptimeleon.predenc.MasterSecret;

import java.util.Objects;

/**
 * The {@link MasterSecret} of the {@link IBEFuzzySW05} generated
 * in the {@link IBEFuzzySW05Setup}.
 */
public class IBEFuzzySW05MasterSecret implements MasterSecret {

    @Represented(restorer = "zp")
    private ZpElement y;

    public IBEFuzzySW05MasterSecret(ZpElement y) {
        this.y = y;
    }

    public IBEFuzzySW05MasterSecret(Representation repr, IBEFuzzySW05PublicParameters kpp) {
        Zp zp = new Zp(kpp.getGroupG1().size());
        new ReprUtil(this).register(zp, "zp").deserialize(repr);
    }

    @Override
    public Representation getRepresentation() {
        return ReprUtil.serialize(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((y == null) ? 0 : y.hashCode());
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
        IBEFuzzySW05MasterSecret other = (IBEFuzzySW05MasterSecret) obj;
        return Objects.equals(y, other.y);
    }

    public ZpElement getY() {
        return y;
    }
}

package de.upb.crypto.predenc.enc.representation;

import de.upb.crypto.craco.enc.representation.RepresentationTest;
import de.upb.crypto.craco.enc.representation.RepresentationTestParams;
import de.upb.crypto.predenc.MasterSecret;
import de.upb.crypto.predenc.abe.PredicateEncryptionScheme;
import de.upb.crypto.predenc.enc.representation.params.*;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class PredEncRepresentationTest extends RepresentationTest {
    protected MasterSecret masterSecret;

    public PredEncRepresentationTest(PredEncRepresentationTestParams params) {
        super(params);
        masterSecret = params.masterSecret;
    }

    @Test
    public void testMasterSecretRepresentation() {
        assertEquals(
                masterSecret,
                ((PredicateEncryptionScheme) scheme).getMasterSecret(masterSecret.getRepresentation())
        );
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<RepresentationTestParams> data() {
        ArrayList<RepresentationTestParams> toReturn = new ArrayList<>();
        toReturn.add(ABEKPGPSW06SmallParams.getParams());
        toReturn.add(ABECPWat11SmallParams.getParams());
        toReturn.add(ABECPWat11Params.getParams());
        toReturn.add(ABEKPGPSW06Params.getParams());
        toReturn.add(IBEFuzzySW05SmallParams.getParams());
        toReturn.add(IBEFuzzySW05Params.getParams());
        toReturn.add(FullIdentParams.getParams());
        toReturn.add(ABECPWat11AsymSmallParams.getParams());
        return toReturn;
    }
}
package com.rpolnx.basic;

import static com.rpolnx.basic.BrazilianState.AC;
import static com.rpolnx.basic.BrazilianState.AL;
import static com.rpolnx.basic.BrazilianState.AM;
import static com.rpolnx.basic.BrazilianState.AP;
import static com.rpolnx.basic.BrazilianState.BA;
import static com.rpolnx.basic.BrazilianState.CE;
import static com.rpolnx.basic.BrazilianState.DF;
import static com.rpolnx.basic.BrazilianState.ES;
import static com.rpolnx.basic.BrazilianState.GO;
import static com.rpolnx.basic.BrazilianState.MA;
import static com.rpolnx.basic.BrazilianState.MG;
import static com.rpolnx.basic.BrazilianState.MS;
import static com.rpolnx.basic.BrazilianState.MT;
import static com.rpolnx.basic.BrazilianState.PA;
import static com.rpolnx.basic.BrazilianState.PB;
import static com.rpolnx.basic.BrazilianState.PE;
import static com.rpolnx.basic.BrazilianState.PI;
import static com.rpolnx.basic.BrazilianState.PR;
import static com.rpolnx.basic.BrazilianState.RJ;
import static com.rpolnx.basic.BrazilianState.RN;
import static com.rpolnx.basic.BrazilianState.RO;
import static com.rpolnx.basic.BrazilianState.RR;
import static com.rpolnx.basic.BrazilianState.RS;
import static com.rpolnx.basic.BrazilianState.SC;
import static com.rpolnx.basic.BrazilianState.SE;
import static com.rpolnx.basic.BrazilianState.SP;
import static com.rpolnx.basic.BrazilianState.TO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum BrazilianState {
    AC,    AL,    AP,    AM,    BA,    CE,    DF,
    ES,    GO,    MA,    MT,    MS,    MG,    PA,
    PB,    PR,    PE,    PI,    RJ,    RN,    RS,
    RO,    RR,    SC,    SP,    SE,    TO
}

enum BrazilianRegion {
    SOUTH(new BrazilianState[]{RS, SC, PR}),
    SOUTHEAST(new BrazilianState[]{SP, MG, RJ, ES}),
    MIDWEST(new BrazilianState[]{MS, MT, GO, DF}),
    NORTHEAST(new BrazilianState[]{BA, SE, AL, PE, PB, RN, CE, PI, MA}),
    NORTH(new BrazilianState[]{TO, PA, AP, RR, AM, RO, AC});

    BrazilianRegion(BrazilianState[] brazilianStates) {
        this.brazilianStates = brazilianStates;
    }

    private BrazilianState[] brazilianStates;

    public BrazilianState[] getBrazilianStates() {
        return brazilianStates;
    }
}

public class EnumConstructor {
    public static void main(String[] args) {
        //Return array of states from SOUTHEAST
        BrazilianState[] southeastStates = BrazilianRegion.SOUTHEAST.getBrazilianStates();

        //Get list of NORTHEAST's State starting with P
        List<BrazilianState> northeastStartingWithP = EnumConstructor.getNortheastStatesStartingWithP_SortedByName();
    }

    private static List<BrazilianState> getNortheastStatesStartingWithP_SortedByName() {
        return Arrays.stream(BrazilianRegion.NORTHEAST.getBrazilianStates())
                .filter(p -> p.name().startsWith("P"))
                .sorted(Comparator.comparing(BrazilianState::name))
                .collect(Collectors.toList());
    }
}
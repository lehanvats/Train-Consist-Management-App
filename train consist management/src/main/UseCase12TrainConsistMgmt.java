import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmt {

    // Goods Bogie model as specified
    public static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }
    }

    /**
     * Checks if the train formation is safe using Streams and allMatch()
     */
    public static boolean isTrainFormationSafe(List<GoodsBogie> bogies) {
        // Evaluate whether every element satisfies the safety condition
        return bogies.stream()
                .allMatch(bogie -> {
                    // Cylindrical bogies must carry only Petroleum
                    if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                        return "Petroleum".equalsIgnoreCase(bogie.getCargo());
                    }
                    // Non-cylindrical bogies (Open, Box, etc.) can carry any cargo
                    return true;
                });
    }

    public static void main(String[] args) {
        System.out.println("....................................................");
        System.out.println(" UC12 Safety Compliance Check for Goods Bogies ");
        System.out.println("....................................................");

        // 1. Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // This will violate the rule

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie bogie : goodsBogies) {
            System.out.println(bogie.getType() + " -> " + bogie.getCargo());
        }

        // 2 & 3. Convert to stream and check compliance
        boolean isSafe = isTrainFormationSafe(goodsBogies);

        System.out.println("Safety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("UC12 safety validation completed...");
    }
}
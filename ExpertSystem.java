import java.util.*;

public class ExpertSystem{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.println("=== HealthCare Expert System ===");
        System.out.println("Enter your symptom:");

        String input=
            sc.nextLine()
            .toLowerCase()
            .trim();

        if(input.contains("fever")){

            System.out.println(
                "Do you have cough or cold?"
            );

            input=sc.nextLine()
                    .toLowerCase()
                    .trim();

            if(input.contains("yes")){

                System.out.println(
                    "Do you also have body pain?"
                );

                input=sc.nextLine()
                        .toLowerCase()
                        .trim();

                if(input.contains("yes")){

                    System.out.println(
                        "Diagnosis: Viral Fever"
                    );

                    System.out.println(
                        "Take rest and drink fluids"
                    );

                }else{

                    System.out.println(
                        "Diagnosis: Mild Fever"
                    );

                    System.out.println(
                        "Take proper rest"
                    );
                }

            }else{

                System.out.println(
                    "Diagnosis: Normal Fever"
                );

                System.out.println(
                    "Monitor temperature regularly"
                );
            }
        }

        else if(input.contains("stomach")){

            System.out.println(
                "Do you have pain or vomiting?"
            );

            input=sc.nextLine()
                    .toLowerCase()
                    .trim();

            if(input.contains("pain")){

                System.out.println(
                    "Is pain severe?"
                );

                input=sc.nextLine()
                        .toLowerCase()
                        .trim();

                if(input.contains("yes")){

                    System.out.println(
                        "Diagnosis: Stomach Infection"
                    );

                    System.out.println(
                        "Consult doctor immediately"
                    );

                }else{

                    System.out.println(
                        "Diagnosis: Digestion Problem"
                    );

                    System.out.println(
                        "Avoid oily food"
                    );
                }
            }

            else if(input.contains("vomiting")){

                System.out.println(
                    "Diagnosis: Food Poisoning"
                );

                System.out.println(
                    "Drink ORS and rest"
                );
            }

            else{

                System.out.println(
                    "Consult doctor"
                );
            }
        }

        else if(input.contains("headache")){

            System.out.println(
                "Do you have stress or lack of sleep?"
            );

            input=sc.nextLine()
                    .toLowerCase()
                    .trim();

            if(input.contains("stress")){

                System.out.println(
                    "Diagnosis: Stress Headache"
                );

                System.out.println(
                    "Take rest and relax"
                );
            }

            else if(input.contains("sleep")){

                System.out.println(
                    "Diagnosis: Sleep Deprivation"
                );

                System.out.println(
                    "Sleep properly"
                );
            }

            else{

                System.out.println(
                    "Consult doctor"
                );
            }
        }

        else if(input.contains("cold")){

            System.out.println(
                "Do you have sneezing?"
            );

            input=sc.nextLine()
                    .toLowerCase()
                    .trim();

            if(input.contains("yes")){

                System.out.println(
                    "Diagnosis: Common Cold"
                );

                System.out.println(
                    "Drink warm water"
                );

            }else{

                System.out.println(
                    "Diagnosis: Allergy"
                );

                System.out.println(
                    "Avoid dust exposure"
                );
            }
        }

        else{

            System.out.println(
                "No matching rule found"
            );

            System.out.println(
                "Please consult doctor"
            );
        }

        sc.close();
    }
}
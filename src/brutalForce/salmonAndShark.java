package brutalForce;

public class salmonAndShark
{
    final static int salmonStartingPopulation = 1000000; //populacja łososi
    final static double sharksConsume = 0.002;  //rekin je 0.002 łososia na minute
    final static double salmonRunaway = 0.002;  //łososie uciekaja 0.002 na minute
    static int minutesPassed = 0;
    final static double e = Math.pow(Math.E, 0.003);
    static boolean[] isExecuted = {false, false, false, false};


    public static void main(String[] args)
    {
        salmonCalc(salmonStartingPopulation);
    }

    public static int salmonCalc(int population)
    {
        for(int i=0; i<10000; i++)
        {
            minutesPassed++;

            population = (int) (population * e);
            population = (int) (population - (population * sharksConsume));
            population = (int) (population - (population * salmonRunaway));


            if(population <= salmonStartingPopulation/2 && population > salmonStartingPopulation/3 && !isExecuted[0])
            {
                System.out.println("Populacja łososi spadła poniżej 1/2 miliona "+minutesPassed);
                isExecuted[0] = true;
            }
            else if(population <= salmonStartingPopulation/3 && population > salmonStartingPopulation/10 && !isExecuted[1])
            {
                System.out.println("Populacja łososi spadła poniżej 1/3 miliona "+minutesPassed);
                isExecuted[1] = true;
            }
            else if(population <= salmonStartingPopulation/10 && population > salmonStartingPopulation/100 && !isExecuted[2])
            {
                System.out.println("Populacja łososi spadła poniżej 1/10 miliona "+minutesPassed);
                isExecuted[2] = true;
            }
            else if(population <= salmonStartingPopulation/100 && population > 100 && !isExecuted[3])
            {
                System.out.println("Populacja łososi spadła poniżej 1/100 miliona "+minutesPassed);
                isExecuted[3] = true;
            }
            else if(population <= 100)
            {
                System.out.println("Salmon became extinct after: "+minutesPassed);
                System.exit(404);
            }
        }
        return salmonCalc(population);
    }
}

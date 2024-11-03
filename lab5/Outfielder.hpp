#include "Player.hpp"
#include "Match.hpp"
#include <cstdlib>
#include <ctime>
class Outfielder : public Player{
    private:
        int noTackles;
        int noPasses;
        int noShots;
        int noAssists;
        int noGoals;
    
    public:
        Outfielder(bool g, std::string n, int a, Country * c) : Player(g, n, a, c){}

        void updateStats(Match * m){
            for (const Player* p : m->getScorersOne()) {
                if (*this == *p) {
                    noGoals ++;
                }
            }

            for (const Player* p : m->getScorersTwo()) {
                if (*this == *p) {
                    noGoals++;
                }
            }

            // Seed the random number generator
            std::srand(static_cast<unsigned int>(std::time(nullptr)));
            noTackles += std::rand() % 11; 
            noPasses += std::rand() % 11;
            noShots += std::rand() % 11;
            noAssists += std::rand() % 2;
            noMatches ++;
    }
    void printStats(){
        std::cout << this->getName() << " STATS: \n";
        std::cout <<"NUMBER OF MATCHES: " << noMatches << "\nNUMBER OF TACKLES: " << noTackles << "\nNUMBER OF PASSES: " << noPasses << "\nNUMBER OF SHOTS: " << noShots << "\nNUMBER OF ASSISTS: " << noAssists << "\nNUMBER OF GOALS: " << noGoals << "\n" <<  std::endl;
    }
    

};


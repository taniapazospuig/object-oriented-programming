#include "Player.hpp"
#include "Match.hpp"
#include <cstdlib>
#include <ctime>

class Goalkeeper : public Player {
    private:
        int noSaves;
        int noGoalsLet;
    public:
        Goalkeeper(bool g, std::string n, int a, Country * c) : Player(g, n, a, c){}

        void updateStats(Match * m){   
            for (const Player* p : m->getTeamOne()->getPlayers()) {
                if (*this == *p) { 
                    noGoalsLet += m->getGoalTwo();
                }
            }

            for (const Player* p : m->getTeamTwo()->getPlayers()) {
                if (*this == *p) {
                    noGoalsLet += m->getGoalOne();
                }
            }

            // Seed the random number generator
            std::srand(static_cast<unsigned int>(std::time(nullptr)));
            noSaves += std::rand() % 11; // Generate a random number between 0 and 10
            noMatches++;
        }

        void printStats(){
            std::cout << this->getName() << " STATS: \n";
            std::cout <<"NUMBER OF MATCHES: " << noMatches << "\nNUMBER OF SAVES: " << noSaves << "\nGOALS LET: " << noGoalsLet << "\n" << std::endl;
        }
        
};

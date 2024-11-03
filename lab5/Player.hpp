#ifndef _PLAYER_
#define _PLAYER_
#include "Country.hpp"
class Match;

class Player{
    protected:
        bool female;
        std::string name;
        int age;
        Country * nationality;
        int noMatches;

    public:
        Player(bool g, std::string n, int a, Country * c){
            female=g;
            name=n;
            age=a;
            nationality=c;
        }

        std::string getName() {
        return name;
        }

        Country * getCountry() {
            return nationality;
        }

        bool isFemale(){
            return female;
        }

        int getAge(){
            return age;
        }

        virtual void updateStats(Match * m) = 0;
        virtual void printStats() = 0;

        bool operator==(const Player& other) const {
            return name == other.name;
        }
};
#endif


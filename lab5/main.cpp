#include "Goalkeeper.hpp"
#include "Outfielder.hpp"

int main(){
    Country *c1 = new Country("Spain");
    Country *c2 = new Country("Argentina");
    Country *c3 = new Country("Brazil");

    Goalkeeper *g1 = new Goalkeeper(false, "Gazzaniga", 31, c2);
    Goalkeeper *g2 = new Goalkeeper(false, "Kepa", 31, c1);

    Outfielder *o1 = new Outfielder(false, "Aleix", 27, c1);
    Outfielder *o2 = new Outfielder(false, "Joselu", 29, c1);
    Outfielder *o3 = new Outfielder(false, "Savio", 19, c3);
    Outfielder *o4 = new Outfielder(false, "Vinicius", 22, c3);
    Outfielder *o5 = new Outfielder(false, "Tsygankov", 27, c1);
    Outfielder *o6 = new Outfielder(false, "Nico Paz", 20, c2);

    Team *t1 = new Team("Girona", c1, Team::MALE);
    Team *t2 = new Team("Madriz", c1, Team::MALE);

    //t1->addPlayer(g1);
    t1->addPlayer(o1);
    t1->addPlayer(o3);
    t1->addPlayer(o5);

   //t2->addPlayer(g2);
    t2->addPlayer(o2);
    t2->addPlayer(o4);
    t2->addPlayer(o6);

    Match *m = new Match(t1, t2);

    m->simulateMatch();
    m->printMatch();
    for (Player* p : m->getTeamOne()->getPlayers()){
        p->updateStats(m);
        p->printStats();
    }
    for (Player* p : m->getTeamTwo()->getPlayers()) {
        p->updateStats(m);
        p->printStats();
    }
    return 0;
}

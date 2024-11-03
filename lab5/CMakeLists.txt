cmake_minimum_required(VERSION 3.24)
project(lab5)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(lab5
        Country.hpp
        Goalkeeper.hpp
        main.cpp
        Match.hpp
        Outfielder.hpp
        Player.hpp
        Team.hpp)

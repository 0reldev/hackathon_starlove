package com.wildcodeschool.hackathon_star_love.repository;

import com.wildcodeschool.hackathon_star_love.entity.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/star_wars?serverTimezone=Europe/Paris";
    private static final String USER = "starWarsUser";
    private static final String PASSWORD = "starWarsPassword$";

    public List<People> findLoveGlobal() {

        List<People> peopleList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            String request = "SELECT * FROM people WHERE id = 4;";
            PreparedStatement statement = connection.prepareStatement(request);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int height = resultSet.getInt("height");
                float mass = resultSet.getFloat("mass");
                String hairColor = resultSet.getString("hair_color");
                String skinColor = resultSet.getString("skin_color");
                String eyeColor = resultSet.getString("eye_color");
                String gender = resultSet.getString("gender");
                int planetId = resultSet.getInt("planet_id");

                People people = new People();
                people.setId(id);
                people.setName(name);
                people.setHeight(height);
                people.setMass(mass);
                people.setHairColor(hairColor);
                people.setSkinColor(skinColor);
                people.setEyeColor(eyeColor);
                people.setGender(gender);
                people.setPlanetId(planetId);

                peopleList.add(people);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }
}
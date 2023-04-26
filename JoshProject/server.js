const express = require("express");
const axios = require("axios");
const app = express();
const bodyParser = require("body-parser");
const request = require('request');
const cors = require("cors");

app.use(cors());
app.use(express.json());
app.use(bodyParser.json());

const port = 3000;


app.get("/users", (req, res) => {
    axios
      .get("http://localhost:8080/Ehospital/MedicalServlet")
      .then((response) => {
        console.log(response.data);
        res.send(response.data);
      })
      .catch((error) => {
        console.log("errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        console.log(error);
        res.sendStatus(500);
      });
  });

  app.post("/signup", (req, res) => {
    const formData = req.body;
    const jsonData = JSON.stringify(formData);
    console.log(jsonData)
    axios
      .post("http://localhost:8080/Ehospital/MedicalServlet", jsonData, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log("error");
        console.log(error);
      });
  });

  
app.listen(port, () => {
  console.log(`Server listening at http://localhost:${port}`);
});
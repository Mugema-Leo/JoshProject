const express = require("express");
const axios = require("axios");
const app = express();
const bodyParser = require("body-parser");
const request = require("request");
const cors = require("cors");
const CircularJSON = require("circular-json");

app.use(cors());
app.use(express.json());
app.use(bodyParser.json());

const port = 3000;

app.get("/users", (req, res) => {
  axios
    .get("http://localhost:8080/mediAppTest/MedicalServlet")
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

// app.post("/signup", (req, res) => {
//   const formData = req.body;
//   const jsonData = JSON.stringify(formData);
//   console.log(jsonData)
//   axios
//     .post("http://localhost:8080/Ehospital/MedicalServlet", jsonData, {
//       headers: {
//         "Content-Type": "application/json",
//       },
//     })
//     .then((response) => {
//       return res.send({"data":response})

//     })
//     .catch((error) => {
//       console.log("error");
//       console.log(error);
//     });
// });

app.post("/signup", (req, res) => {
  const formData = req.body;
  axios
    .post("http://localhost:8080/mediAppTest/MedicalServlet", formData, {
      headers: {
        "Content-Type": "application/json",
      },
    })
    .then((response) => {
      return res.send({ data: response.data });
    })
    .catch((error) => {
      console.log("error");
      console.log(error);
    });
});

app.post("/login", (req, res) => {
  const data = req.body;
  const jsonData = JSON.stringify(data);

  request.post(
    {
      url: "http://localhost:8080/mediAppTest/MedicalServlet",
      form: jsonData,
    },
    (error, response, body) => {
      if (error) {
        // handle any errors
        console.error(error);
      } else {
        // send the response from the Java Tomcat server back to the client
        res.send(body);
      }
    }
  );
});

app.post("/loginPharmacist", (req, res) => {
  const data = req.body;
  const jsonData = JSON.stringify(data);

  request.post(
    {
      url: "http://localhost:8080/mediAppTest/MedicalServlet",
      form: jsonData,
    },
    (error, response, body) => {
      if (error) {
        // handle any errors
        console.error(error);
      } else {
        // send the response from the Java Tomcat server back to the client
        res.send(body);
      }
    }
  );
});

app.post("/accessPharmacist", (req, res) => {
  const data = req.body;
  const jsonData = JSON.stringify(data);

  request.post(
    {
      url: "http://localhost:8080/mediAppTest/MedicalServlet",
      form: jsonData,
    },
    (error, response, body) => {
      if (error) {
        // handle any errors
        console.error(error);
      } else {
        // send the response from the Java Tomcat server back to the client
        res.send(body);
      }
    }
  );
});

app.post("/physicianAccess", (req, res) => {
  const data = req.body;
  const jsonData = JSON.stringify(data);

  request.post(
    {
      url: "http://localhost:8080/mediAppTest/MedicalServlet",
      form: jsonData,
    },
    (error, response, body) => {
      if (error) {
        // handle any errors
        console.error(error);
      } else {
        // send the response from the Java Tomcat server back to the client
        res.send(body);
      }
    }
  );
});

app.listen(port, () => {
  console.log(`Server listening at http://localhost:${port}`);
});

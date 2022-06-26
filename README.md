# weather-forecast
A simple weather forecast android application.

## Architecture
This application tries to follow all design principle proposed by Google. This makes the code more modular and thus more easy to improve, refactor, reuse and maintain. As proposed by the android team, the code is first divided into a ui and data layers. The optional domain layer in our case is skipped due to a lack of needs. The ui layer mainly holds the view components and the main activity. This application uses the single activity model. The ui state is kept in viewmodels, keeping the state during configuration changes. The data layer is more complex and includes repositories, which get data from data sources. The information uses models adapted for the business logic of the application.

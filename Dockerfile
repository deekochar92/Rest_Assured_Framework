FROM deekochar/assignment:1

COPY src home/TMDB_BYNDER/src

COPY pom.xml home/TMDB_BYNDER/pom.xml

COPY TestNG.xml home/TMDB_BYNDER/TestNG.xml

COPY allure-report home/TMDB_BYNDER/allure-report

COPY config.properties home/TMDB_BYNDER/config.properties

WORKDIR home/TMDB_BYNDER

ENTRYPOINT ["mvn","clean","test"]

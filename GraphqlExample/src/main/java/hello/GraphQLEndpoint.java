package hello;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.servlet.SimpleGraphQLServlet;

import graphql.schema.GraphQLSchema;

//https://www.howtographql.com/graphql-java/1-getting-started/
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6284291806806135535L;

    private static GraphQLSchema buildSchema() {
        LinkRepository linkRepository = new LinkRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(linkRepository))
                .build()
                .makeExecutableSchema();
    }

	public GraphQLEndpoint() {
        super(buildSchema());
    }

//	public GraphQLEndpoint() {
//		super(SchemaParser.newParser().file(System.getProperty("user.dir") + "/schema.graphqls") // parse the schema file created earlier
//				.build().makeExecutableSchema());
//	}
}
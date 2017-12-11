package restaurantcomment.services;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;

public class EntityManagerFilter implements javax.servlet.Filter {

    EntityManagerProvider entityManagerProvider = new EntityManagerProvider();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        entityManagerProvider.startNewEm();


        filterChain.doFilter(servletRequest,servletResponse);

        entityManagerProvider.closeJpa();
    }

    @Override
    public void destroy() {

    }
}

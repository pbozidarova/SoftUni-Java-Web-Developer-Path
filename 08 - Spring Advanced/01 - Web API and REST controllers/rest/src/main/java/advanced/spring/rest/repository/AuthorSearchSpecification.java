package advanced.spring.rest.repository;

import advanced.spring.rest.model.Author;
import advanced.spring.rest.model.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class AuthorSearchSpecification implements Specification<Author> {

    private final String authorName;
    private final String bookTitle;

    public AuthorSearchSpecification(String authorName, String bookTitle) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();

        if(authorName != null){
            p.getExpressions().add(
                    cb.and(cb.equal(root.get("name"), authorName))
            );
        }

        if(bookTitle != null){
            Subquery<Book> bookSubquery = query.subquery(Book.class);
            Root<Book> subqueryRoot = bookSubquery.from(Book.class);
            bookSubquery.select(subqueryRoot);

            bookSubquery.where(
                    cb.equal(root, subqueryRoot.get("author")),
                    cb.equal(subqueryRoot.get("title"), bookTitle)
            );

            p.getExpressions().add(cb.exists(bookSubquery));
        }

        return p;
    }
}

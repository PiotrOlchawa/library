package org.library.service;

import org.library.domain.BookCopies;
import org.library.domain.BookCopiesDto;
import org.library.mapper.BookCopiesMapper;
import org.library.repository.BookCopiesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCopiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookCopiesService.class);

    @Autowired
    BookCopiesDao bookCopiesDao;
    @Autowired
    BookCopiesMapper bookCopiesMapper;

    public BookCopiesDto changeBookStatus(BookCopiesDto bookCopiesDto) {
        BookCopies bookCopies = bookCopiesDao.findById(bookCopiesDto.getId());
        LOGGER.debug("bookCopiesDto ID " + bookCopiesDto.getId());
        bookCopies.setStatus(bookCopiesDto.getStatus());
        return bookCopiesMapper.mapBookCopiesToBookCopiesDto(bookCopiesDao.save(bookCopies));
    }
}

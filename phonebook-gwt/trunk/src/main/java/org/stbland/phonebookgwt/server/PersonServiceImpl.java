package org.stbland.phonebookgwt.server;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.stbland.phonebookgwt.bean.PersonDto;
import org.stbland.phonebookgwt.client.service.PersonService;
import org.stbland.phonebookgwt.shared.logger.Logger;
import org.stbland.phonebookgwt.shared.logger.LoggerFactory;

@SuppressWarnings("serial")
public class PersonServiceImpl extends AbtractService implements PersonService {

	private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	public AbstractList<PersonDto> findAll() {
		logger.info("findAll");

		AbstractList<PersonDto> list = new ArrayList<PersonDto>(2);

		list.add(new PersonDto("Stéphane", "BEAUFORT"));
		list.add(new PersonDto("Christian", "KIEHL"));
		list.add(new PersonDto("Christophe", "ANTOINE"));
		list.add(new PersonDto("Alain", "BARADEL"));

		return list;
	}

	private boolean isFullNameLike(PersonDto person, String fullNameLike) {

		return isFullNameLike(person.getFullName(), fullNameLike)
				|| isFullNameLike(
						person.getLastName() + " " + person.getFirstName(),
						fullNameLike);
	}

	private boolean isFullNameLike(String fullName, String fullNameLike) {

		return fullName.startsWith(fullNameLike);
	}

	public AbstractList<PersonDto> findSuggestions(String fullNameLike,
			int limit) {
		logger.info("findSuggestions (fullNameLike: " + fullNameLike
				+ ", limit: " + Integer.toString(limit));

		final List<PersonDto> dtoList = findAll();

		AbstractList<PersonDto> newSuggestions = new ArrayList<PersonDto>(limit);
		PersonDto dto;
		for (Iterator<PersonDto> dtoIterator = dtoList.iterator(); dtoIterator
				.hasNext();) {
			dto = dtoIterator.next();
			if (isFullNameLike(dto, fullNameLike)) {
				newSuggestions.add(dto);

				if (newSuggestions.size() == limit) {
					break;
				}
			}
		}

		logger.info("newSuggestions.size: " + newSuggestions.size());

		return newSuggestions;

	}

	public PersonDto find(String firstName, String lastName) {
		logger.info("find (firstName: " + firstName + ", lastName: " + lastName);

		final List<PersonDto> dtoList = findAll();

		PersonDto dto;
		for (Iterator<PersonDto> dtoIterator = dtoList.iterator(); dtoIterator
				.hasNext();) {
			dto = dtoIterator.next();
			if (dto.getFirstName().equals(firstName)
					&& dto.getLastName().equals(lastName)) {
				return dto;
			}
		}

		return null;
	}

}

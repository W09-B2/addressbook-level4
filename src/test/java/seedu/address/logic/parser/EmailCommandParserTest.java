package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_SUBJECT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_SUBJECT_DESC;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.Test;

import seedu.address.logic.commands.EmailCommand;
//@@author KevinCJH
/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the EmailCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the EmailCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class EmailCommandParserTest {

    private EmailCommandParser parser = new EmailCommandParser();

    @Test
    public void parse_validArgs_returnsEmailCommand() {
        assertParseSuccess(parser, "1", new EmailCommand(INDEX_FIRST, ""));
        assertParseSuccess(parser, "1 " + VALID_EMAIL_SUBJECT_DESC, new EmailCommand(INDEX_FIRST, VALID_EMAIL_SUBJECT));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, EmailCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "1 " + INVALID_EMAIL_DESC,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EmailCommand.MESSAGE_USAGE));
    }
}

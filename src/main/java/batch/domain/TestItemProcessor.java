package batch.domain;

import org.springframework.batch.item.ItemProcessor;

public class TestItemProcessor implements ItemProcessor<SourcePage, SourcePage> {

	@Override
	public SourcePage process(SourcePage sourcePage) throws Exception {
		System.out.println("========TestItemProcessor==========");
		System.out.println(sourcePage.toString());
		return sourcePage;
	}

}

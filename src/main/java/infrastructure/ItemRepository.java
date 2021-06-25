package infrastructure;

import domain.Item;
import domainservice.IItemRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ItemRepository implements IItemRepository {
    private static final Logger logger = LogManager.getLogger(ItemRepository.class);
    @Override
    public Iterable<Item> getAll() {
        return null;
    }

    @Override
    public Item get(int id) {
        return null;
    }

    @Override
    public Item add(Item o) {
        return null;
    }

    @Override
    public void save(Item o) {
        logger.info("Saving");
    }

    @Override
    public void delete(Item o) {
        logger.info("Deleting");
    }
}
